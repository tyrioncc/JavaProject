package dev.dao;

import dev.entity.Player;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlayerDao {

	/**
	 *
	 * 通过id查询玩家
	 *@param playerId
	 *@return player
	 */
	Player queryById(long playerId);

	/**
	 *
	 * 查询所有的玩家
	 * @param offset 查询起始位置
	 * @param limit 查询条数
	 * @return List<Player>
	 **/
	List<Player> queryAll(@Param("offset") int offset, @Param("limit") int limit);

	/**
	 *
	 * 按Kd对所有玩家排序
	 * @param offset 查询起始位置
	 * @param limit 查询条数
	 * @return List<Player>
	 **/
	List<Player> queryAllByOrder(@Param("offset") int offset, @Param("limit") int limit);
}
