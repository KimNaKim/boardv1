package com.example.boardv1.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(BoardRepository.class) // AutoWired로 가져올 클래스 Import하는 어노테이션
@DataJpaTest // EntityManager를 IoC에 등록하는 어노테이션
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void findById_test() {
        // given
        int id = 1;

        // when
        Board board = boardRepository.findById(id);

        // eye
        System.out.println(board);
    }

    @Test
    public void findAll_test() {
        List<Board> boards = boardRepository.findAll();

        for (Board b : boards) {
            System.out.println(b);
        }
    }

    @Test
    public void save_test() {
        // given
        Board board = new Board();
        board.setTitle("title7");
        board.setContent("content7");

        // when
        boardRepository.save(board);

        // eye
        List<Board> boards = boardRepository.findAll();

        for (Board b : boards) {
            System.out.println(b);
        }
    }

    @Test
    public void delete_test() {
        // given
        int id = 6;
        Board board = boardRepository.findById(id);
        // when
        boardRepository.delete(board);

        // eye
        List<Board> boards = boardRepository.findAll();

        for (Board b : boards) {
            System.out.println(b);
        }
    }

}
