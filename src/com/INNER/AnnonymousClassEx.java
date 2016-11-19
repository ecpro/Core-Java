package com.INNER;

public class AnnonymousClassEx {
	
	public static Anno getAnno() {
		
		return new Anno() {
			int x = 1;
			@Override
			public void prnt() {
				System.out.println("inside the annonymous class" + x);
			}
			
			@Override
			public void out() {
				System.out.println("inside out of anno");
			}
			
		};
		
	}
		public static AbsAnno getAbsAnno() {
			return new AbsAnno() {
				
				private int x = 20;
				

				@Override
				public void prnt() {
					y = 10;
					System.out.println("inside annonymous class" + y);
				}

				@Override
				public void out() {
					System.out.println("inside out" + x);
				}
				
			};
		}
	

	public static void main(String[] args) {
		
		Anno anno = AnnonymousClassEx.getAnno();
		anno.out();
		anno.prnt();
		AbsAnno absAnno = AnnonymousClassEx.getAbsAnno();
		absAnno.prnt();
		absAnno.out();
	}

}

interface Anno {
	void prnt();
	void out();
}
