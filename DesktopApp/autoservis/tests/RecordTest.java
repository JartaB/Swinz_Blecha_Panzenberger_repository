import org.junit.jupiter.api.Test;
import sample.Record;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecordTest {
    Record testRecord= new Record("1","Tonda Tester","1.5.2021","735486973","TN225566","vyfuk");
    @Test
    void getId() {
        assertEquals("1",testRecord.getId());
    }

    @Test
    void getName() {
        assertEquals("Tonda Tester",testRecord.getName());
    }

    @Test
    void getDate() {
        assertEquals("1.5.2021",testRecord.getDate());
    }

    @Test
    void getPhone() {
        assertEquals("735486973",testRecord.getPhone());
    }

    @Test
    void getSpz() {
        assertEquals("TN225566",testRecord.getSpz());
    }

    @Test
    void getProblem() {
        assertEquals("vyfuk",testRecord.getProblem());
    }

    @Test
    void setId() {
        testRecord.setId("2");
        assertEquals("2",testRecord.getId());
    }

    @Test
    void setName() {
        testRecord.setName("Tomáš Tester");
        assertEquals("Tomáš Tester",testRecord.getName());
    }

    @Test
    void setDate() {
        testRecord.setDate("2.6.2022");
        assertEquals("2.6.2022",testRecord.getDate());
    }

    @Test
    void setPhone() {
        testRecord.setPhone("737555999");
        assertEquals("737555999",testRecord.getPhone());
    }

    @Test
    void setSpz() {
        testRecord.setSpz("TN556622");
        assertEquals("TN556622",testRecord.getSpz());
    }

    @Test
    void setProblem() {
        testRecord.setProblem("brzdy");
        assertEquals("brzdy",testRecord.getProblem());
    }
}