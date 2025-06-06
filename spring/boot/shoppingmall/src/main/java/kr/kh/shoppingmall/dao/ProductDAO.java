package kr.kh.shoppingmall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.shoppingmall.model.vo.BuyListVO;
import kr.kh.shoppingmall.model.vo.BuyVO;
import kr.kh.shoppingmall.model.vo.CartVO;
import kr.kh.shoppingmall.model.vo.CategoryVO;
import kr.kh.shoppingmall.model.vo.ProductVO;

public interface ProductDAO {

	List<CategoryVO> selectCategoryList();

	CategoryVO selectCategoryByName(String ca_name);

	CategoryVO selectCategoryByCode(String ca_code);

	void insertCategory(CategoryVO category);

	boolean updateCategory(CategoryVO category);

	boolean deleteCategory(int ca_num);

	List<ProductVO> selectProductList(int pr_ca_num);

	boolean insertProduct(ProductVO product);

	boolean updateProduct(ProductVO product);

	String selectNextPrCode(int pr_ca_num);

	ProductVO selectProduct(String pr_code);

	boolean insertBuy(BuyVO buy);

	void insertBuyList(List<BuyListVO> list);

	void updateProductAmount(BuyListVO bl);

	List<BuyVO> selectBuyList(String bu_me_id);

	boolean updateBuy(int bu_num, String bu_me_id);

	CartVO selectCart(CartVO cart);

	boolean insertCart(CartVO cart);

	boolean updateCart(CartVO cart);

	List<CartVO> selectCartList(String ct_me_id);

	void deleteCart(String ct_pr_code, String me_id);
	
}