import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends DBCON {

	public OrderDAO() {
	}

	public List<ProductVO> orderInfo(ProductVO vo) {
		List<ProductVO> list = new ArrayList<ProductVO>();

		try {
			dbConn();

			String sql = "select p_name, p_num, p_code, s_price from product";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductVO voTemp = new ProductVO();
				voTemp.setP_name(rs.getString(1));
				voTemp.setP_num(rs.getInt(2));
				voTemp.setP_code(rs.getInt(3));
				voTemp.setS_price(rs.getInt(4));
				list.add(voTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return list;
	}

	public ProductVO getOrder(String order) {
		ProductVO voTemp = new ProductVO();
		try {
			dbConn();
			String sql = "select p_name, p_num, s_price from product where p_name = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order);
			rs = pstmt.executeQuery();

			rs.next();
			voTemp.setP_name(rs.getString(1));
			voTemp.setP_num(rs.getInt(2));
			voTemp.setS_price(rs.getInt(3));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return voTemp;
	}

	public List<P_codeVO> p_classList(P_codeVO vo) {
		List<P_codeVO> list = new ArrayList<P_codeVO>();
		try {
			dbConn();

			String sql = "select p_class, p_code from p_code";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				P_codeVO pvo = new P_codeVO();
				pvo.setP_class(rs.getString(1));
				pvo.setP_code(rs.getInt(2));
				list.add(pvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return list;
	}
}
