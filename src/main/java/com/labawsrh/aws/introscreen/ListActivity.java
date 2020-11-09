package com.labawsrh.aws.introscreen;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class ListActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        listView=(ListView)findViewById(R.id.listView);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        new Connection().execute();


    }
    class Connection extends AsyncTask<String ,String,String> {

        @Override
        protected String doInBackground(String... strings) {
            String result = "";
            String host = "http://192.168.1.6/ones/subject.php";
            try {
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(host));
                HttpResponse response = client.execute(request);
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                StringBuffer stringBuffer = new StringBuffer("");
                String line = "";
                while ((line = reader.readLine()) != null) {
                    stringBuffer.append(line);

                }
                reader.close();
                result = stringBuffer.toString();
            } catch (Exception e) {
                return new String("there exception:" + e.getMessage());

            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            try{
                JSONArray jsonResult=new JSONArray(result);
                    for(int i=0;i<jsonResult.length();i++){
                        JSONObject reservation=jsonResult.getJSONObject(i);
                        int id_reservation=reservation.getInt("id_reservation");
                        int numcin=reservation.getInt("numcin");
                        String heure_entre=reservation.getString("heure_entre");
                        String heure_sortie=reservation.getString("heure_sortie");
                        String num_mat=reservation.getString("num_mat");
                        String Newligne=System.getProperty("line.separator");
                        //String line=id_reservation+"-"+numcin+"-"+heure_entre+"-"+heure_sortie+"-"+num_mat;
                        String line="ID : "+id_reservation+Newligne+"Num_Cin : "+numcin+Newligne+"Heure_Entrée : "+heure_entre+Newligne+
                                "Heure_Sortie : "+heure_sortie+Newligne+"Num_Matricule : "+num_mat;
                        adapter.add(line);

                    }



            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            }


            }
        }
    }
