package com.vakeel.master.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.vakeel.master.modal.StateMaster;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JpaStateMasterRepositoryTest {

	@Autowired
	private JpaStateMasterRepository jpaStateMasterRepository;
	
	@Test
	public void getStateList() {
		List<StateMaster> list = jpaStateMasterRepository.findAllByIsDeleted(false);
		assertEquals(2, list.size());
	}
}
