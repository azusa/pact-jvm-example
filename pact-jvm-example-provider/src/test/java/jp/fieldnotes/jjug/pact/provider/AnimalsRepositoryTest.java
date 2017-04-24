package jp.fieldnotes.jjug.pact.provider;

import jp.fieldnotes.jjug.pact.provider.domain.AnimalsEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnimalsRepositoryTest {

    @Autowired
    private AnimalsRepository repository;

    @Test
    public void findByType() throws Exception {
        List<AnimalsEntity> entity = repository.findByType("serval");
        assertThat(entity.size(), is(1));
    }

}