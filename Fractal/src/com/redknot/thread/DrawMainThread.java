package com.redknot.thread;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.SurfaceHolder;

import com.redknot.g.Hualan;
import com.redknot.g.Huangguan;
import com.redknot.g.Koch;
import com.redknot.g.Levy;
import com.redknot.g.Sierpinski;
import com.redknot.g.Tree;
import com.redknot.util.ID;

public class DrawMainThread implements Runnable {

	private SurfaceHolder holder;
	private int width;
	private int height;
	private int color;
	private int id;
	private int n;

	public DrawMainThread(SurfaceHolder holder, int width, int height,
			int color, int id, int n) {
		this.holder = holder;
		this.width = width;
		this.height = height;
		this.color = color;
		this.id = id;
		this.n = n;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			synchronized (holder) {
				Paint p = new Paint();
				p.setColor(this.color);
				p.setStyle(Style.STROKE);
				
				if (this.id == ID.KOCH1) {
					Koch k = new Koch();
					k.koch1(0, this.height / 2, this.width, this.height / 2,
							this.n, holder, path, p);
				} else if (this.id == ID.KOCH2) {
					Koch k = new Koch();
					k.koch2(0, this.height / 2, this.width, this.height / 2,
							this.n, holder, path, p);
				} else if (this.id == ID.HUALAN) {
					Hualan h = new Hualan();
					h.hualan(0, this.height / 2, this.width, this.height / 2,
							n, holder, path, p);
				} else if (this.id == ID.HUANGGUAN) {
					Huangguan h = new Huangguan();
					h.huangguan(0, this.height / 2, this.width,
							this.height / 2, n, holder, path, p);
				} else if (this.id == ID.LEVY) {
					Levy l = new Levy();
					l.levy(0 + 200, this.height / 2, this.width - 200,
							this.height / 2, n, holder, path, p);
				}

				else if (this.id == ID.SIERPINSKI) {
					Sierpinski s = new Sierpinski();
					int x1 = this.width / 2;
					int y1 = this.height / 2 + 200
							- (int) (Math.sqrt(3) * (this.width / 2));
					int x2 = 0;
					int y2 = this.height / 2 + 200;
					int x3 = this.width;
					int y3 = this.height / 2 + 200;
					s.sier_gasket(x1, y1, x3, y3, x2, y2, n, holder, path, p);
				}

				else if (this.id == ID.TREE) {
					Tree t = new Tree();
					t.tree1(0, this.height / 2, this.width, this.height / 2, n,
							holder, path, p);
				}

			}
			// (0, this.height/2, this.width, this.height/2, 5, holder, path,p);
		} catch (Exception e) {

		}

	}

	Path path = new Path();

}