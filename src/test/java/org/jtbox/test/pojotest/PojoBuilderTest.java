package org.jtbox.test.pojotest;

import java.util.List;

import org.jtbox.test.dto.AuthorDTO;
import org.jtbox.test.dto.BookDTO;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PojoBuilderTest {
	
	final static Logger log = LoggerFactory.getLogger("org.jtbox.test.pojotest");

    @Test
    public void testOneAuthor() throws Exception {
    	//authors have multiple books
        AuthorDTO author = PojoBuilder.createOne(AuthorDTO.class);
        Assert.assertNotNull(author);
        Assert.assertNotNull(author.getComment());
        Assert.assertNotNull(author.getFirstname());
        //Assert.assertNotNull(author.getId());
        Assert.assertNotNull(author.getName());
        Assert.assertNotNull(author.getNationnality());
        Assert.assertNotNull(author.getBirthDate());
        Assert.assertNotNull(author.getDeathDate());
        Assert.assertNotNull(author.getWritten());
        Assert.assertTrue(author.getWritten().isEmpty());
        log.info("{}", author);
    }
    
    @Test
    public void testOneBook() throws Exception {
    	//a book has usually one author
        BookDTO book = PojoBuilder.createOne(BookDTO.class);
        Assert.assertNotNull(book);
        Assert.assertNotNull(book.getComment());
        Assert.assertNotNull(book.getTitle());
        Assert.assertNotNull(book.getCreationDate());
        Assert.assertNotNull(book.getIsbn());
        Assert.assertNotNull(book.getPriceInEthereum());
        Assert.assertNotNull(book.getPriceInEuro());
        Assert.assertNotNull(book.getWordCount());
        
        // for now, external classes are not handled.
        Assert.assertNull(book.getAuthor());
        log.info("{}", book);
    }
    
    @Test
    public void testOneSpecific() throws Exception {
        AuthorDTO author = PojoBuilder.createOne(AuthorDTO.class, 100);
        Assert.assertNotNull(author);
        log.info("{}", author);
    }
    
    @Test
    public void testSome() throws Exception {
        List<AuthorDTO> authors = PojoBuilder.createMany(AuthorDTO.class, 100);
        Assert.assertNotNull(authors);
        Assert.assertFalse(authors.isEmpty());
        Assert.assertEquals(100, authors.size());
        log.info("{}", authors);
    }
}
