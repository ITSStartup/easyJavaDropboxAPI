package com.its.main;

import java.util.Locale;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;

public class Main {
	public static void main(String[] args) {
			final String APP_KEY = "APP_KEY HERE";
			final String APP_SECRET = "APP_SECRET HERE";
		DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);
		DbxRequestConfig config = new DbxRequestConfig("JavaTutorial/1.0",	Locale.getDefault().toString());
		DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);
		String authorizeUrl = webAuth.start();
		System.out.println("AuthorizeURL " + authorizeUrl);
		System.out.println("3. Copy the authorization code.");

		try {
			String code = "TOKEN HERE";
		
		DbxAuthFinish authFinish = null;
			authFinish = webAuth.finish(code);
			DbxClient client = new DbxClient(config, authFinish.accessToken);
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

