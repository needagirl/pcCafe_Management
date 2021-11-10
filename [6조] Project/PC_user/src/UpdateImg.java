import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLException;

import javax.imageio.ImageIO;

public class UpdateImg extends DBCON{
	BufferedImage bi;
	public UpdateImg() {
	}
	public void ImgUpdate() {
		int p_num = 0;
		try {
			dbConn();
			for (p_num = 1; p_num < 50; p_num++) {
				int pn = p_num+100;
				String sql = "update product set p_img =? where p_num =? ";
				pstmt = conn.prepareStatement(sql);
				File f = new File("img/"+pn+".jpg");
				FileInputStream fis = new FileInputStream(f);
				pstmt.setBinaryStream(1, fis, fis.available());
				pstmt.setInt(2,p_num);
				int c = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	public BufferedImage getDBImage(int p_num) {
		try {
			dbConn();
			String sql = "select p_img from product where p_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_num);
			rs = pstmt.executeQuery();
			rs.next();
			InputStream is = rs.getBinaryStream(1);
			bi = ImageIO.read(is);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return bi;
	}
	

	public static void main(String[] args) {
		new UpdateImg().ImgUpdate();
	}

}
