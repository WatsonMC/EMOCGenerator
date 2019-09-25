import org.junit.Assert;
import org.junit.Test;

import Controller.ConfirmationController;

public class ConfirmationControllerTest {
		
	
	
		@Test
		public void testPrependEmocName() {
			String emocNo = "1010";
			String test1 = "1\\2\\3\\4\\5\\6\\teststring";
			String res1 = "1\\2\\3\\4\\5\\6\\1010 teststring";
//			System.out.println(ConfirmationController.prependEmocNoToFilePath(test1, emocNo));
			Assert.assertEquals(res1, ConfirmationController.prependEmocNoToFilePath(test1, emocNo));

		}
		
		@Test
		public void testAppendFileToTgtDir() {
			String test1 = "Test\\Dir";
			String source = "This\\is\\the\\source.txt";
			String res1 = "Test\\Dir\\source.txt";
			
			Assert.assertEquals(res1, ConfirmationController.appendFileToTgtDir(source, test1));
		}

}
