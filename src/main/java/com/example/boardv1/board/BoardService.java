package com.example.boardv1.board;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor // final이 붙어 있는 모든 필드를 초기화하는 생성자를 만들라고 spring에게 지시하는 어노테이션
public class BoardService {
    private final BoardRepository bRepository; // 의존성 주입

    // 함수 정의

    public Board insert(String title, String content) {
        Board board = new Board();
        board.setContent(content);
        board.setTitle(title);
        Board GBoard = bRepository.save(board);
        return GBoard;
    }

    public void delete(int id) {
        Board board = bRepository.findById(id);
        bRepository.delete(board);
    }

    public Board detail(int id) {
        Board board = bRepository.findById(id);

        return board;
    }

    public List<Board> findAll() {
        List<Board> list = bRepository.findAll();

        return list;
    }

    public void update(int id, String title, String content) {
        bRepository.update(id, title, content);
    }
}
