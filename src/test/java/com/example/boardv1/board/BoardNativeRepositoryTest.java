package com.example.boardv1.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(BoardNativeRepository.class) // AutoWired로 가져올 클래스 Import하는 어노테이션
@DataJpaTest // EntityManager를 IoC에 등록하는 어노테이션
public class BoardNativeRepositoryTest {

    @Autowired // 어노테이션 DI 기법
    private BoardNativeRepository bNativeRepository;

    @Test
    public void findById_test() {
        // given
        int id = 1;

        // when
        Board board = bNativeRepository.findById(id);

        // eye
        System.out.println(board);
    }

    @Test
    public void findAll_test() {
        List<Board> boards = bNativeRepository.findAll();

        for (Board b : boards) {
            System.out.println(b);
        }
    }

    @Test
    public void save_test() {
        // given
        String title = "title7";
        String content = "content7";

        // when
        bNativeRepository.save(title, content);

        // eye
        List<Board> boards = bNativeRepository.findAll();

        for (Board b : boards) {
            System.out.println(b);
        }
    }

    @Test
    public void deleteById_test() {
        // given
        int id = 6;

        // when
        bNativeRepository.deleteById(id);

        // eye
        List<Board> boards = bNativeRepository.findAll();

        for (Board b : boards) {
            System.out.println(b);
        }

    }

    @Test
    public void updateById_test() {
        // given
        int id = 1;
        String title = "updateTitle1";
        String content = "updateContent1";

        // when
        bNativeRepository.updateById(id, content, title);

        // eye
        List<Board> boards = bNativeRepository.findAll();

        for (Board b : boards) {
            System.out.println(b);
        }
    }
}
