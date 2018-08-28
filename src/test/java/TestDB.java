import org.junit.*;
import java.sql.SQLException;

public class TestDB {
    MyDB db;

    @Before
    public void setupDB() throws SQLException {
        db = new MyDB();
        db.connect();
    }


    @Test
    public void testAddEntry(){
        try {
            db.newEntry("Novice", 3);
            Assert.assertEquals("Novice", db.readEntry("Novice"));
            db.deleteEntry(db.getID("Novice"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteEntry(){
        try {
            db.newEntry("Novice", 3);
            db.deleteEntry(db.getID("Novice"));
            Assert.assertNull(db.readEntry(db.getID("Novice")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void disconnectDB(){
        db.disconnect();
    }

}
