package com.eventzone.cosc412;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.ui.ModelMap;

import com.eventzone.cosc412.controller.EventController;

import de.bechte.junit.runners.context.HierarchicalContextRunner;


@RunWith(HierarchicalContextRunner.class)
public class EventControllerTest {
	private ModelMap map;
    private EventController ctrl;

    @Before
    public void setUp() throws Exception {
        map = new ModelMap();
       // repository = mock(RecordRepository.class);
    //    ctrl = new EventController(repository);
    }
    
    public class Home {

        @Test
        public void testTest() throws Exception {
          
        	 String message = "Hi!" + "Robert";
             assertEquals(message, "Hi!Robert");

        }

    }
/*
    public class Home {

        @Test
        public void shouldAddInsertRecordToModelMap() throws Exception {
            ctrl.home(map);

            assertThat(map, hasKey("insertRecord"));
            assertTrue(map.get("insertRecord") instanceof Record);

            Record insertRecord = (Record) map.get("insertRecord");
            assertNull(insertRecord.getData());
        }

        @Test
        public void shouldQueryRepositoryForAllRecords() throws Exception {
            ctrl.home(map);

            verify(repository, only()).findAll();
        }

        @Test
        public void shouldAddRecordsFromRepositoryToModelMap() throws Exception {
            when(repository.findAll()).thenReturn(Arrays.asList(new Record(), new Record(), new Record()));

            ctrl.home(map);

            assertThat(map, hasKey("records"));
            assertTrue(map.get("records") instanceof List);

            List<Record> records = getRecords();
            assertThat(records, hasSize(3));
        }

        @SuppressWarnings("unchecked")
        private List<Record> getRecords() {
            return (List<Record>) map.get("records");
        }
    }

    public class InsertData {

        private MapBindingResult bindingResult;

        @Before
        public void setUp() throws Exception {
            bindingResult = new MapBindingResult(new HashMap<>(), "insertRecord");
        }

        @Test
        public void shouldSaveRecordWhenThereAreNoErrors() throws Exception {
            Record record = new Record();
            insertData(record);

            verify(repository, times(1)).save(record);
        }

        @Test
        public void shouldNotSaveRecordWhenThereAreErrors() throws Exception {
            bindingResult.addError(new ObjectError("", ""));

            insertData(new Record());

            verify(repository, never()).save(any(Record.class));
        }

        @Test
        public void shouldAddNewInsertRecordToModelMap() throws Exception {
            Record record = new Record();
            insertData(record);

            assertThat(map, hasKey("insertRecord"));
            assertThat(map.get("insertRecord"), is(not(record)));
        }

        @Test
        public void shouldAddRecordsToModelMap() throws Exception {
            insertData(new Record());

            assertThat(map, hasKey("records"));
        }

        private void insertData(Record record) {
            ctrl.insertData(map, record, bindingResult);
        }
    }
    */
}
