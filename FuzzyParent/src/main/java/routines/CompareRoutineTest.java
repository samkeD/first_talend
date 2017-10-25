package routines;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.hamcrest.collection.IsEmptyCollection;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import static org.hamcrest.MatcherAssert.assertThat;

/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class CompareRoutineTest {

    /**
     * helloExample: not return value, only print "hello" + message.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("world") input: The string need to be printed.
     * 
     * {example} helloExemple("world") # hello world !.
     */
	  String row = "[ROWNUM=null,CO_CDE=null,PROD_CDE=null,TRNS_CDE=null,TRNS_CDE_DESC=null,DR_CR_IND=null,REVERSAL_IND=null,EBUCKS_IND=null]";
	    StringBuilder  differences ;
	    List<List<String>> lists ;
	    final String FILENAME = "C:\\Users\\f4839870\\Desktop\\test.txt";
	    final File s = FileUtils.getFile(FILENAME);

	    private static final String NEW_LINE_SEPARATOR = "\n";
	    String rows ="big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=42,CO_CDE=15,PROD_CDE=CDA,TRNS_CDE=8542,TRNS_CDE_DESC=TELLERs TRF FROM                         ,DR_CR_IND=C,REVERSAL_IND=N,EBUCKS_IND= ]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=1047,CO_CDE=15,PROD_CDE=DDA,TRNS_CDE=5808,TRNS_CDE_DESC=CASH HANDLING FEES                      ,DR_CR_IND=D,REVERSAL_IND=N,EBUCKS_IND= ]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=2331,CO_CDE=15,PROD_CDE=DDA,TRNS_CDE=7789,TRNS_CDE_DESC=TERM LOAN FACILITY FEE                  ,DR_CR_IND=D,REVERSAL_IND=N,EBUCKS_IND= ]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=2380,CO_CDE=15,PROD_CDE=DDA,TRNS_CDE=7849,TRNS_CDE_DESC=CELLPHONE BANKING TRANSFER TO           ,DR_CR_IND=D,REVERSAL_IND=N,EBUCKS_IND= ]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=2440,CO_CDE=15,PROD_CDE=DDA,TRNS_CDE=7909,TRNS_CDE_DESC=FOREX INWARD FEE                        ,DR_CR_IND=D,REVERSAL_IND=N,EBUCKS_IND= ]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=2737,CO_CDE=15,PROD_CDE=DDA,TRNS_CDE=8261,TRNS_CDE_DESC=#MONEY TRANSFER FEE                     ,DR_CR_IND=D,REVERSAL_IND=N,EBUCKS_IND= ]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=2771,CO_CDE=15,PROD_CDE=DDA,TRNS_CDE=8301,TRNS_CDE_DESC=#AIRTIME TOP UP                         ,DR_CR_IND=D,REVERSAL_IND=N,EBUCKS_IND= ]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=2821,CO_CDE=15,PROD_CDE=DDA,TRNS_CDE=8363,TRNS_CDE_DESC=FX SWIFT COMMISSION                     ,DR_CR_IND=D,REVERSAL_IND=N,EBUCKS_IND= ]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=3258,CO_CDE=15,PROD_CDE=MLSSS,TRNS_CDE=4402,TRNS_CDE_DESC=HOUSEOWNERS INS (UNALLOC) REVS           ,DR_CR_IND=C,REVERSAL_IND=Y,EBUCKS_IND= ]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=7173,CO_CDE=942,PROD_CDE=DDA,TRNS_CDE=7161,TRNS_CDE_DESC=AIRTIME TOPUP                           ,DR_CR_IND=D,REVERSAL_IND=N,EBUCKS_IND=Ys]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=7188,CO_CDE=94,PROD_CDE=DDA,TRNS_CDE=80202,TRNS_CDE_DESC=FNB APP GEO PAYMENT TO                  ,DR_CR_IND=D,REVERSAL_IND=N,EBUCKS_IND= ]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=42,CO_CDE=15,PROD_CDE=CDA,TRNS_CDE=8542,TRNS_CDE_DESC=TELLER TRF FROM                         ,DR_CR_IND=C,REVERSAL_IND=N,EBUCKS_IND= ]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=1047,CO_CDE=15,PROD_CDE=DDA,TRNS_CDE=5808,TRNS_CDE_DESC=#CASH HANDLING FEES                     ,DR_CR_IND=D,REVERSAL_IND=N,EBUCKS_IND= ]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=2331,CO_CDE=15,PROD_CDE=DDA,TRNS_CDE=7789,TRNS_CDE_DESC=#TERM LOAN FACILITY FEE                 ,DR_CR_IND=D,REVERSAL_IND=N,EBUCKS_IND= ]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=2380,CO_CDE=15,PROD_CDE=DDA,TRNS_CDE=7849,TRNS_CDE_DESC=FNB APP TRANSFER TO                     ,DR_CR_IND=D,REVERSAL_IND=N,EBUCKS_IND= ]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=2440,CO_CDE=15,PROD_CDE=DDA,TRNS_CDE=7909,TRNS_CDE_DESC=#FOREX INWARD FEE                       ,DR_CR_IND=D,REVERSAL_IND=N,EBUCKS_IND= ]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=2737,CO_CDE=15,PROD_CDE=DDA,TRNS_CDE=8261,TRNS_CDE_DESC=MONEY TRANSFER FEE                      ,DR_CR_IND=D,REVERSAL_IND=N,EBUCKS_IND= ]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=2771,CO_CDE=15,PROD_CDE=DDA,TRNS_CDE=8301,TRNS_CDE_DESC=AIRTIME TOPUP                           ,DR_CR_IND=D,REVERSAL_IND=N,EBUCKS_IND= ]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=2821,CO_CDE=15,PROD_CDE=DDA,TRNS_CDE=8363,TRNS_CDE_DESC=#FX SWIFT COMMISSION                    ,DR_CR_IND=D,REVERSAL_IND=N,EBUCKS_IND= ]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=3258,CO_CDE=15,PROD_CDE=MLS,TRNS_CDE=4402,TRNS_CDE_DESC=HOUSEOWNERS INS (UNALLOC) REV           ,DR_CR_IND=C,REVERSAL_IND=Y,EBUCKS_IND= ]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=7173,CO_CDE=94,PROD_CDE=DDA,TRNS_CDE=7161,TRNS_CDE_DESC=AIRTIME TOPUP                           ,DR_CR_IND=D,REVERSAL_IND=N,EBUCKS_IND=Y]\n" +
	            "big_data_talend_demo.routinecompareparenttest_0_1.RoutineCompareParentTest$row1Struct@15fbaa4[ROWNUM=7188,CO_CDE=94,PROD_CDE=DDA,TRNS_CDE=8020,TRNS_CDE_DESC=FNB APP GEO PAYMENT TO                  ,DR_CR_IND=D,REVERSAL_IND=N,EBUCKS_IND= ]\n";
	    @Before
	    public void setUpList() throws Exception {
	       lists = CompareRoutine.createLists(row);
	    }

	    @Before
	    public void setUpStringBuffer() throws Exception {
	        differences = new StringBuilder(CompareRoutine.writeFileHeading(row));

	    }

	    @Before
	    public void setUpLists() throws Exception {
	        for(String s :rows.split(NEW_LINE_SEPARATOR) )
	            CompareRoutine.populateLists(s,lists);
	    }

	    @Test
	    public void writeFileHeading() throws Exception {
	        assertNotNull(differences);
	        assertTrue("differences string has been initialized",differences.length()>0);

	    }

	    @Test
	    public void createLists() throws Exception {
	        //3. Check List Size
	        assertThat("list size is "+lists.size(),lists, hasSize(8));

	        assertThat("list size is "+lists.size(),lists.size(), is(8));
	        assertThat("list has been created and it's not empty",lists, not(IsEmptyCollection.empty()));

	    }

	    @Test
	    public void populateLists() throws Exception {
	        //3. Check List Size
	        assertThat(lists, hasSize(8));
	        assertThat(lists.size(), is(8));
	        //5. check empty list
	        assertThat(lists, not(IsEmptyCollection.empty()));
	        assertThat(new ArrayList<>(), IsEmptyCollection.empty());

	    }

	    @Test
	    public void writeDifferencesFile() throws Exception {
	        differences.append(CompareRoutine.getDataDifferences(lists));
	        assertNotNull(differences);
	        assertTrue("differences string has been initialized",differences.length()>0);
	        CompareRoutine.writeDifferencesFile(FILENAME,differences);
	        final String fileString = FileUtils.readFileToString(s);
	        assertEquals("file and differences string are the same",differences.toString(),fileString);
	    }
}
