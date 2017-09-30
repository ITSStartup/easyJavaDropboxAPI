package com.its.easyjavadropbox.api.interfaces;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.files.SearchMatch;
import com.dropbox.core.v2.files.ThumbnailSize;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public interface EasyJavaDropBoxService {

    /**
     *
     * @return all files for dropboxPath
     * @throws DbxException
     */
    List<Metadata> listFiles() throws DbxException;

    /**
     *
     * @param basePath inform the path of the file
     * @param query what you wish search
     * @return
     * @throws DbxException
     */
    List<SearchMatch> searchFile(String basePath, String query) throws DbxException;

    DbxClientV2 getClient();

    /**
     *
     * @param newpath must be absolute path e.g: /nameOfFolder
     */
    void changeDropboxPath(String newpath);

    /**
     *
     * @param size
     * @param fileName
     * @param outputStream
     * @throws IOException
     * @throws DbxException
     */
    public void writeThumbnail(ThumbnailSize size, String fileName, OutputStream outputStream) throws DbxException, IOException;

    /**
     *
     * @param finalName inform finalName of the file e.g: myphoto.png
     * @param inputStreamContent content Stream of file
     * @throws DbxException
     * @throws IOException
     */
    public void saveToDropbox(String finalName, InputStream inputStreamContent) throws DbxException, IOException;

    /**
     * Use this method only if the file is located in root "/" of your app
     *
     * @param currentNameFile inform name of file that will be renamed
     * e.g:file.txt
     * @param newNameFile inform new name of file e.g: myfile.txt
     * @throws DbxException is thrown if file is not found error 404
     */
    public void renameFileRoot(String currentNameFile, String newNameFile) throws DbxException;

    /**
     *
     * @param pathFolder inform the folder where the file is located e.g:
     * /myfolder/
     * @param currentNameFile inform the name of file that will be renamed
     * @param newNameFile the name that will be renamed e.g: photous.png
     * @throws DbxException if the file is not found in the path informed
     * exception is thrown.
     */
    public void renameFile(String pathFolder, String currentNameFile, String newNameFile) throws DbxException;

}
