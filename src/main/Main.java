package main;

import java.io.File;
import interfaces.TranferComplete;

public class Main {

	private static FileLogic fileExplorer;

	public static void main(String[] args) {
		fileExplorer = new FileLogic("/home/evo05/Imagenes", new TranferComplete(){

			@Override
			public void success(String msg) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void fail(String msg) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
}
