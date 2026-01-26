package com.example.boardv1.board;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardNativeRepository {

    private final EntityManager em; // 인터페이스, 의존성 주입

    // Repository
    public Board findById(int id) {
        Query query = em.createNativeQuery("select * from board_tb where id = :id", Board.class);
        query.setParameter("id", id);
        Board board = (Board) query.getSingleResult();
        return board;
    }

    public List<Board> findAll() {
        Query query = em.createNativeQuery("select * from board_tb ", Board.class);
        List<Board> boards = query.getResultList();
        return boards;
    }

    public void save(String title, String content) {
        Query query = em.createNativeQuery(
                "insert into board_tb (title, content, created_at) values(:title, :content, now())");
        query.setParameter("title", title)
                .setParameter("content", content);
        query.executeUpdate();
    }

    public void updateById(int id, String content, String title) {
        Query query = em.createNativeQuery("update board_tb set title = :title, content = :content where id = :id");
        query.setParameter("title", title)
                .setParameter("content", content)
                .setParameter("id", id);
        query.executeUpdate();
    }

    public void deleteById(int id) {
        Query query = em.createNativeQuery("delete from board_tb where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
