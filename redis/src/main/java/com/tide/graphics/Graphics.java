package com.tide.graphics;

import java.io.IOException;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.process.StandardStream;

public class Graphics {

	public static void main(String[] args) throws IOException, InterruptedException, IM4JavaException {

		IMOperation op = new IMOperation();
		//op.addImage("C://Users//lenovo//Pictures//xx//x1.jpg");
		op.define("bit-depth=8");
		op.define("png:color-type=64");
		op.addImage("C://Users//lenovo//Pictures//xx//1.png");
//		op.resize(640,1008);//尺寸
//		op.quality(35d);//质量
//		op.density(72);//分辨率
		// fillcolor
		//op.fill("PNG-8");
//		op.colors(-100);
//		op.colorspace("RGB");
//		op.pointsize(8);
		
		op.colors(16);
		op.depth(16);
		
		
		//op.addImage("C://Users//lenovo//Pictures//xx//x1-1.jpg");
		op.addImage("C://Users//lenovo//Pictures//xx//1-1.png");
		// IM4JAVA是同时支持ImageMagick和GraphicsMagick的，如果为true则使用GM，如果为false支持IM。
		ConvertCmd cmd = new ConvertCmd(true);
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.indexOf("win") >= 0) { // linux下不要设置此值，不然会报错
			cmd.setSearchPath("C://Program Files//GraphicsMagick-1.3.21-Q8");
		}
		cmd.setErrorConsumer(StandardStream.STDERR);
		//cmd.run(op, "C://Users//lenovo//Pictures//xx//x1.jpg", "C://Users//lenovo//Pictures//xx//x2.jpg");
		op.verbose();
		System.out.println(op.verbose());

		cmd.run(op);
		

	}

}
