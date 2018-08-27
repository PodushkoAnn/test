import org.junit.*;
import java.sql.SQLException;

public class TestDB {

    MyDB db;

    @Before
    public void setupDB() throws SQLException {
        db = new MyDB();
    }


    @Test
    public void testAddEntry(){

        try {
            db.newEntry("Novice", 3);
            int x = db.getID("Novice");
            Assert.assertEquals("Novice", db.readEntry(x));
            db.deleteEntry(x);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
