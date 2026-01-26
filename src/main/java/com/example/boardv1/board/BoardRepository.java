package com.example.boardv1.board;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em; // 인터페이스, 의존성 주입

    // Repository
    public Board findById(int id) {
        Board findBoard = em.find(Board.class, id);
        return findBoard;
    }

    public List<Board> findAll() {
        List<Board> findBoards = em.createQuery("select b.id, b.title from Board b", Board.class).getResultList(); // 객체지향쿼리
        return findBoards;
    }

    public void save(Board board) {
        em.persist(board);
    }

    public void delete(Board board) {
        em.remove(board);
    }

}
