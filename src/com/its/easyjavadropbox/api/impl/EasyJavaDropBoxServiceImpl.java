package com.its.easyjavadropbox.api.impl;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.files.SearchMatch;
import com.dropbox.core.v2.files.SearchResult;
import com.dropbox.core.v2.files.ThumbnailFormat;
import com.dropbox.core.v2.files.ThumbnailSize;
import com.its.easyjavadropbox.api.interfaces.EasyJavaDropBoxService;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class EasyJavaDropBoxServiceImpl implements EasyJavaDropBoxService {

    private String root = "/";
    private String dropboxPath = root;
    private DbxRequestConfig config;
    private DbxClientV2 client;

    /**
     *
     * @param dropboxPath inform path to be considered. You must have permission
     * to access
     * @param token generated by dropbox
     */
    public EasyJavaDropBoxServiceImpl(String dropboxPath, String token) {
        this.dropboxPath = dropboxPath;
        setup(token);
    }

    /**
     * Path default here is "/"
     *
     * @param token token generated by dropbox
     */
    public EasyJavaDropBoxServiceImpl(String token) {
        setup(token);
    }

    private void setup(String token) {
        config = new DbxRequestConfig("ITS/1.0");
        client = new DbxClientV2(config, token);
    }

    @Override
    public void changeDropboxPath(String newpath) {
        dropboxPath = newpath;
    }

    @Override
    public List<SearchMatch> searchFile(String basePath, String query) throws DbxException {
        SearchResult result = client.files().search(basePath, query);
        return result.getMatches();
    }

    @Override
    public List<Metadata> listFiles() throws DbxException {
        ListFolderResult result = client.files().listFolder(dropboxPath);
        return result.getEntries();
    }

    @Override
    public DbxClientV2 getClient() {
        return client;
    }

    @Override
    public void writeThumbnail(ThumbnailSize size, String fileName, OutputStream outputStream) throws DbxException, IOException {
        client.files()
                .getThumbnailBuilder(dropboxPath + fileName)
                .withFormat(ThumbnailFormat.JPEG)
                .withSize(size)
                .download(outputStream);
    }

    @Override
    public void saveToDropbox(String finalName, InputStream inputStreamContent) throws DbxException, IOException {
        String finalNamePathFull = dropboxPath + finalName;
        client.files().uploadBuilder(finalNamePathFull).uploadAndFinish(inputStreamContent);
    }

    @Override
    public void renameFileRoot(String currentNameFile, String newNameFile) throws DbxException {
        String currentPathFile = root + currentNameFile;
        String newFile = root + newNameFile;
        client.files().moveV2(currentPathFile, newFile);
    }

    @Override
    public void renameFile(String pathFolder, String currentPathFile, String newNameFile) throws DbxException {
        String fullCurrentPath = pathFolder + currentPathFile;
        newNameFile = pathFolder + newNameFile;
        client.files().moveV2(fullCurrentPath, newNameFile);
    }
}
