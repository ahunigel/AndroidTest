package yc.get_image;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * 得到网络图片
 * 
 * @author 叶超
 * 
 */
/*
 * 读取网络图片，注意添加网络权限 <uses-permission android:name="android.permission.INTERNET"
 * />
 */
public class GetTheNetImage extends Activity {
	// private String IMG_URL =
	// "http://www.fzlqqtx.cn/uploads/allimg/101025/1_101025191847_1.jpg";
	private String images[] = {
			"http://www.qqt6.com/uploads/allimg/100820/1_100820065756_1.jpg",
			"http://www.qq74.net/upimg/allimg/110113/0135115L5-11.jpg",
			"http://www.kanfzl.com/article/UploadPic/2010-10/20101013932918.jpg",
			"http://www.feizl.com/upload2007/2011_05/1105241418527525.jpg",
			"http://www.oaiqq.com/uploads/allimg/101008/21441229e-15.jpg",
			"http://www.tombit.cn/news/UploadPic/2010-12/2010122814432671.jpg" };
	GridView netGridView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		netGridView = (GridView)findViewById(R.id.gridview);
		netGridView.setAdapter(new ImagesAdapter(this));
		// netImage = (ImageView) findViewById(R.id.netImage);
		// load();
	}
	public class ImagesAdapter extends BaseAdapter{
		private Context mContext;

		public ImagesAdapter(Context context) {
			mContext = context;
		}
		public int getCount() {
						return images.length;
		}

		public Object getItem(int arg0) {
						return null;
		}

		public long getItemId(int arg0) {
						return 0;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			// System.out.println(convertView);
			// if -- else 为了节省内存空间，减少对象的创建
			if (convertView == null) {
				imageView = new ImageView(mContext);
				//设置显示图片的大小
				imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				imageView.setPadding(0, 0, 0, 0);
			} else {
				imageView = (ImageView) convertView;
			}
			 try {
				 URL aURL = new URL(images[position]);
				 URLConnection con = aURL.openConnection();
				 con.connect();
				 InputStream is = con.getInputStream();
				 /* 建立缓冲区是一个良好的编程习惯. */
				 BufferedInputStream bis = new BufferedInputStream(is);
				 /* 解析网络上的图片 */
				 Bitmap bm = BitmapFactory.decodeStream(bis);
				 imageView.setImageBitmap(bm);
				 bis.close();
				 is.close();
				 /* 这时图片已经被加载到ImageView中. */
				
				 } catch (IOException e) {
				 e.printStackTrace();
				 }
			return imageView;
		}
		
	}
	
}