package rocks.zipcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class NotezTest {


//    @Test
//    void addNoteToGeneralCategory(){
//        //given
//        Notez testNote = new Notez();
//        testNote.remember();
//        //when
//        //then
//    }


//    @Test
//    void createOrAppendTest(){
//        //given
//        Notez testNote = new Notez();
//        testNote.createOrAppend();
//        //when
//        //then
//    }


    @Test
    void forgetNoteTest(){
        //given
        Notez testNote = new Notez();
        testNote.forget();
        //when
        //then
    }


    @Test
    void editOrReplaceNote(){
        //given
        Notez testNote = new Notez();
        testNote.editOrReplace();
        //when
        //then
    }



    @Test
    void testApp() {
        assertEquals(1, 1);
    }

    @Test
    void addToCategory() {
        //G
        Notez testNote = new Notez();
        String[] argv = {"-r", "Doe a deer a female deer", "Ketchup"};
        //W
        String expected = "Doe a deer a female deer";
        String actual = argv.toString();
        testNote.addToCategory("General", argv);
        System.out.println(testNote.printResults());
    }
}
