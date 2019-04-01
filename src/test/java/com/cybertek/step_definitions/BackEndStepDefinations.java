package com.cybertek.step_definitions;

import com.cybertek.pages.MySelfPage;
import com.cybertek.pages.MyTeamPage;
import com.cybertek.pages.SignInPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.DatabaseUtility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.cybertek.utilities.DatabaseUtility.getRowMap;

public class BackEndStepDefinations {

    @Then("team information should match database records")
    public void team_information_should_match_database_record() {

        //Get the name of the team, it will be used to get team id
        MyTeamPage myTeamPage = new MyTeamPage();
        BrowserUtils.wait(3);
        String teamName = myTeamPage.teamName.getText();
        System.out.println(teamName);

        //build the sql based on the team name
        String sql = "select u.firstname " +
                " from users u join team t on t.id = " +
                "u.team_id and t.name = '" + teamName + "';";


        //getColumnData returns data of a single column
        List<Object> names = DatabaseUtility.getColumnData(sql, "firstname");
        System.out.println(names);


        //get the actual names

        List<String> actualNames = BrowserUtils.getElementsText(myTeamPage.allNames);


        Assert.assertEquals(names.size(), actualNames.size());


        for (Object name : names) {
            Assert.assertTrue(actualNames.contains(name.toString()));
        }
    }

    List<Object> clusterTable;

    @Given("there is a list of clusters in the clusters table")
    public void there_is_a_list_of_clusters_in_the_clusters_table() {
        //get the list of id on the cluster table

        String sql = "select id from cluster;";

        clusterTable = DatabaseUtility.getColumnData(sql, "id");
        System.out.println(clusterTable);

    }

    List<Object> roomTable;

    @Given("all rooms have a clusters id in room table")
    public void all_rooms_have_a_clusters_id_in_room_table() {
        // get the list of cluster_id from the room table
        String sql = "select * from room;";

        roomTable = DatabaseUtility.getColumnData(sql, "cluster_id");
        System.out.println(roomTable);
    }

    @Then("all the clusters ids must be from the clusters table")
    public void all_the_clusters_ids_must_be_from_the_clusters_table() {
        //compare
//        for (Object o : roomTable) {
//            Assert.assertTrue(clusterTable.contains(o));
//        }

        Assert.assertTrue(clusterTable.containsAll(roomTable));
    }


    @Then("correct user information should be displayed for {string}")
    public void correct_user_information_should_be_displayed_for(String email) {
        String sql = "select  firstname, lastname, t.name\n" +
                "from users u\n" +
                "join team t on t.id = u.team_id\n" +
                "where email = '" + email + "';";

        Map<String, Object> userInfo = DatabaseUtility.getRowMap(sql);

        System.out.println(userInfo);

        String eName = userInfo.get("firstname") + " " + userInfo.get("lastname");
        String eTeam = userInfo.get("name").toString();

        System.out.println(eName);
        System.out.println(eTeam);

        MySelfPage mySelfPage = new MySelfPage();
        Assert.assertEquals(eName, mySelfPage.name.getText());
        Assert.assertEquals(eTeam, mySelfPage.team.getText());

    }


    @When("user logs in any user")
    public void user_logs_in_any_user() {
        // get the size of the table
        Long count = (Long) DatabaseUtility.getCellValue("select count (*) from users;");


        // generate random number in the scope

        double rand = Math.random() * count + 1;
        System.out.println(rand);

        // get random row using that number

        String sql = "select firstname,lastname,email from users limit 1 offset " + rand + ";";

        Map<String, Object> userInfo = DatabaseUtility.getRowMap(sql);
        System.out.println(userInfo);


        String password = ((String) userInfo.get("firstname") + userInfo.get("lastname")).toLowerCase();
        String email = (String) userInfo.get("email");

        System.out.println("email: " + email);
        System.out.println("password: " + password);

        SignInPage signInPage = new SignInPage();
        signInPage.login(email,password);

    }


}
