package dev.service.imple;

import dev.dao.PlayerDao;
import dev.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImple implements PlayerService {
	@Autowired
	private PlayerDao playerDao;

}
