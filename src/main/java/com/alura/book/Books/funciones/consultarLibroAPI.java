package com.alura.book.Books.funciones;

import com.alura.book.Books.apiBooks.ResponseApi;
import com.alura.book.Books.apiBooks.ResponseJson;
import com.alura.book.Books.apiBooks.ConvertData;
import com.alura.book.Books.models.*;
import com.alura.book.Books.repository.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class consultarLibroAPI {

    private static final ResponseApi responseApi = new ResponseApi ();
    private static final ResponseJson responseJSON = new ResponseJson ();
    private static final String URL_BASE = "https://gutendex.com/books";
    private static final ConvertData conversor = new ConvertData ();

    private static final Scanner searchTitle = new Scanner(System.in);

    public void saveRepositoryTitle() throws JSONException {

        boolean validacionTitulo;

        do {

            System.out.print("Ingrese el título del libro que desea buscar:  ");
            var searchedBookByTitle = searchTitle.nextLine ();

            if (searchedBookByTitle != null) {

                validacionTitulo = true;
                String URL_API = URL_BASE + "//?search=" + searchedBookByTitle.replace(" ", "%20");
                String filterMessage = " con el titulo: " + searchedBookByTitle;

                saveRepositoryFilter(URL_API, filterMessage);
            } else {

                validacionTitulo = false;
                System.out.println ( "Peticion Denegada: Para realizar la consulta debe ingresar un titulo de libro." );
            }

        } while (!validacionTitulo);

    }

    public void saveRepositoryID(long id) throws JSONException {

        String URL_API = URL_BASE + "/" + id + "/";

        saveRepository(URL_API);
    }

    public void saveRepositoryFilter (String URL_API, String filterMessage) throws JSONException {

        BooksRepository bookrepository = RepositoryController.GetBookRepository();
        AuthorsRepository authorsrepository = RepositoryController.GetAuthorsRepository();

        List<Book> msgQuery = new ArrayList<> ();

        List<BookRecord> msgFilter = new ArrayList<> ();

        String BookExist = "N";
        String ExistAuthor = "N";

        int idAuthor = 0;
        int idAuthorBook = 0;

        var json = responseApi.getData (URL_API);

        ApiRecord ApiRecord = conversor.obtenerDatos(json, ApiRecord.class);

        for (int i = 0; i < ApiRecord.results ().size (); i++) {

            var json2 = ApiRecord.results ().get (i);

            int id = json2.id ();
            String title = json2.title ();
            List<AuthorsRecord> authors = json2.authors ();
            List<String> listLanguages = json2.languages ();
            String languages = json2.languages ().getFirst ();
            int download_count = json2.download_count ();

            String nameAuthor = authors.getFirst ().name ();

            ExistAuthor =  authorsrepository.valExistAuthor ( nameAuthor );
            Authors authorsR = new Authors ( authors.getFirst () );

            if (!(Objects.equals ( ExistAuthor , "S" ))) {
                idAuthor = authorsrepository.seqAuthors();
                authorsR.setId ( idAuthor );
                authorsrepository.save ( authorsR );
            }

            BookExist =  bookrepository.valExistBook ( id );

            if (!(Objects.equals ( BookExist , "S" ))) {

                if (!(Objects.equals ( ExistAuthor , "S" ))) {
                    idAuthorBook = idAuthor;
                } else {
                    idAuthorBook = authorsrepository.getIdAuthor( nameAuthor );
                }

                BookRecord bookrecord = new BookRecord ( id, title, authors, listLanguages ,download_count, idAuthorBook  );
                Book book = new Book ( bookrecord );
                book.setAuthor_id ( idAuthorBook );
                book.setLanguages ( languages );
                bookrepository.save ( book );

                msgFilter.add ( bookrecord );
            } else {
                idAuthorBook = authorsrepository.getIdAuthor( nameAuthor );
                BookRecord bookrecord = new BookRecord ( id, title, authors, listLanguages ,download_count, idAuthorBook  );
                Book book = new Book ( bookrecord );
                book.setAuthor_id ( idAuthorBook );
                book.setLanguages ( languages );

                msgFilter.add ( bookrecord );
            }

        }
        msgList.msgListBook(msgFilter, filterMessage);

    }

    public void saveRepository (String URL_API) throws JSONException {

        BooksRepository bookrepository = RepositoryController.GetBookRepository();
        AuthorsRepository authorsrepository = RepositoryController.GetAuthorsRepository();

        String BookExist = "N";
        String ExistAuthor = "N";

        JSONObject json = responseJSON.getJson (URL_API);

        String jsonStringBook = json.toString (  );

        int getIdLibro = (int) json.get ( "id" );

        String jsonStringAutors = String.valueOf ( json.getJSONArray ( "authors" ) )
                .replace ("[{", "{")
                .replace ("}]", "}");

        BookExist =  bookrepository.valExistBook ( getIdLibro );

        if (!(Objects.equals ( BookExist , "S" ))) {
            BookRecord bookData = conversor.obtenerDatos(jsonStringBook, BookRecord.class);

            System.out.println( "bookData: " + jsonStringBook);
            Book book = new Book ( bookData );
            bookrepository.save ( book );
        }

        AuthorsRecord authorsRecord = conversor.obtenerDatos(jsonStringAutors, AuthorsRecord.class);
        Authors authors = new Authors ( authorsRecord );
        ExistAuthor =  authorsrepository.valExistAuthor ( authors.getName () );

        if (!(Objects.equals ( ExistAuthor , "S" ))) {
            authors.setId ( authorsrepository.seqAuthors() );
            authorsrepository.save ( authors );
        }

    }

}