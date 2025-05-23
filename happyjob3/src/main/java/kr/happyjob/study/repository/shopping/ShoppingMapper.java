package kr.happyjob.study.repository.shopping;


import kr.happyjob.study.vo.Shopping.ShoppingModel;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

import kr.happyjob.study.vo.Shopping.ShoppingModel;

@Mapper
public interface ShoppingMapper {

    public List<ShoppingModel>  productlist(Map<String, Object> parammap);

    public ShoppingModel  productdetail(Map<String, Object> parammap);

    public List<ShoppingModel>  imagelist(Map<String, Object> parammap);

}
