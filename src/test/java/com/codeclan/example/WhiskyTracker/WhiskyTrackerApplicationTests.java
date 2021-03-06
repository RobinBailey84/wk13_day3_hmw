package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetWhiskeyOfYear() {
		List<Whisky> results = whiskyRepository.findWhiskyByYear(2018);
		assertEquals(2, results.size());
	}

	@Test
	public void canGetDistilleryByRegion() {
		List<Distillery> results = distilleryRepository.findDistilleryByRegion("Highland");
		assertEquals(1, results.size());
	}

	@Test
	public void canGetWhiskyByDistilleryAndAge(){
		List<Whisky> results = whiskyRepository.findWhiskyByAgeAndDistillery(15, 1L);
		assertEquals(1, results.size());
	}

	@Test
	public void canGetWhiskyByRegion() {
		List<Whisky> results = whiskyRepository.findWhiskyByRegion("Highland");
		assertEquals(2, results.size());
	}

	@Test
	public void canGetDistilleriesWithWhiskyAge() {
		List<Distillery> results = distilleryRepository.findDistilleriesThatHaveWhiskyOfAge(12);
		assertEquals(2, results.size());
	}
}
