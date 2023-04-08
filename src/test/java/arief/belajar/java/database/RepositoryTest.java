package arief.belajar.java.database;

import arief.belajar.java.database.entity.Comment;
import arief.belajar.java.database.repository.CommentRepository;
import arief.belajar.java.database.repository.CommentRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RepositoryTest {

    private CommentRepository commentRepository;

    @BeforeEach
    void beforeEach() {
        commentRepository = new CommentRepositoryImpl();
    }

    @Test
    void testInsert() {
        Comment comment = new Comment("arief@test","hi");
        commentRepository.insert(comment);

        Assertions.assertNotNull(comment.getId(),comment.getEmail());
        System.out.println(comment.getId());
    }

    @Test
    void testFindById() {
        Comment comment = commentRepository.findById(2204);
        Assertions.assertNotNull(comment);
        System.out.println(comment.getId());
        System.out.println(comment.getEmail());
        System.out.println(comment.getComment());

        Comment notFound = commentRepository.findById(1_000_000);
        Assertions.assertNull(notFound);
    }

    @Test
    void testFindByAll() {
        List<Comment> comments = commentRepository.findAll();
        System.out.println(comments.size());
    }
}
