package main;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import interfaces.TranferComplete;

public class FileLogic {
	
	private File[] files;
	private Boolean backup_and_erase = false;
	private HashMap<String, File> local_files;
	private HashMap<String, File> remote_files;
	
	public FileLogic(String path, TranferComplete complete) {
		
		local_files = new HashMap<String, File>();
		remote_files = new HashMap<String, File>();

		sincronize("/home/evo05/Imágenes", "/home/evo05");
		complete.success("papa");
	}
	
	private void showFiles(File[] files) {
		for(File file : files) {
			System.out.println(" "+file+" ");
		}
	}
	
	private void sincronize(String local_path, String remote_path) {
		
		File[] container_local_files, container_remote_files;
		
		container_local_files = new File(local_path).listFiles();
		container_remote_files = new File(remote_path).listFiles();
		
		if(container_remote_files.length != 0) {
			
			if(container_local_files.length != 0) {
				
				//Iterates local directory and fill the hashmap
				for(File file : container_local_files) {
					local_files.put(file.getAbsolutePath(), file);
				}
				
				//Iterates remote directory and fill the hashmap
				for(File file : container_remote_files) {
					remote_files.put(file.getAbsolutePath(), file);
				}
				
				
				for(String local_key : local_files.keySet()) {
					for(String remote_key : local_files.keySet()) {
						
					}
				}
				
				//Compate each file with each file to find out differences
				Iterator i = local_files.entrySet().iterator();
				while(i.hasNext()) {
			        Map.Entry local_file = (Map.Entry)i.next();
			        
			    	Iterator i_remote = remote_files.entrySet().iterator();
					while(i_remote.hasNext()) {
				        Map.Entry remote_file = (Map.Entry)i_remote.next();
				        
				        local_file.getValue().equals(remote_file.getValue()); 
					}
			        
				}	
			} else{
				//If there are not files on local but yes in remote, it must do a backup
				Iterator i_remote = remote_files.entrySet().iterator();
				while(i_remote.hasNext()) {
			        Map.Entry remote_file = (Map.Entry)i_remote.next();
			        
			        
				}
			}
			
		}
		
		/*
		 * 
		private void copyFile(File source, File dest) {
		    Files.copy(source, dest);
		}*/
		
		/*for(File file : remote_directory) {
			System.out.println(" "+file+" ");
		}*/
	}

	/**
	 *@return true if erase 
	 * */
	public boolean getFlag() {
		return backup_and_erase;
	}
	
	/**
	 * That flag validates if does a backup and earse the original data or not
	 **/
	public void setFlag(boolean erase) {
		backup_and_erase = erase;
	}

}
