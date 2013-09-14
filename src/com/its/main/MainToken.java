package com.its.main;

import java.util.Locale;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
/*
This class connect to DROPBOX API via TOKEN Generated. Execute DropboxGenerateToken.
*/
public class MainToken {
	public static void main(String[] args) {
		DbxRequestConfig config = new DbxRequestConfig("JavaTutorial/1.0",	Locale.getDefault().toString());
		try {
			DbxClient client = new DbxClient(config, "TOKEN HERE");
			System.out.println("Linked account: "
					+ client.getAccountInfo().displayName);
			DbxEntry.WithChildren listing = client.getMetadataWithChildren("/");
			System.out.println("Files in the root path:"); 
			 
			for (DbxEntry child : listing.children) {
				System.out.println("	" + child.name + ": " + child.toString());
			}
		}catch (DbxException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

