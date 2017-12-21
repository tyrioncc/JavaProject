package dev.dao;

import dev.BaseTest;
import dev.entity.Player;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlayerDaoTest extends BaseTest {

	@Autowired
	private PlayerDao playerDao;

	@Test
	public void testQueryById() throws Exception{
		long playerId = 3;
		Player player = playerDao.queryById(playerId);
		System.out.println(player);
	}

	@Test
	public void testQueryAll() throws Exception{
		List<Player> players = playerDao.queryAll(0, 6);
		for (Player player : players){
			System.out.println(player);
		}
	}

	@Test
	public void testQueryAllByOrder() throws Exception{
		List<Player> players = playerDao.queryAllByOrder(1, 6);
		for (Player player : players){
			System.out.println(player);
		}
	}
}
