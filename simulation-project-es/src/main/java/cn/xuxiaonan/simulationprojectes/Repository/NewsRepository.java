package cn.xuxiaonan.simulationprojectes.Repository;

import cn.xuxiaonan.simulationprojectes.entities.New;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface NewsRepository extends ElasticsearchRepository<New,String> {
}
