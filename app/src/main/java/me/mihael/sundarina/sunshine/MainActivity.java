package me.mihael.sundarina.sunshine;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import me.mihael.sundarina.sunshine.MainFragment.OnSelectedButtonListener;

public class MainActivity extends AppCompatActivity implements OnSelectedButtonListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /*   if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
         //   getSupportFragmentManager().beginTransaction()
         //           .add(R.id.container, new SecondFragment())
           //         .commit();
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /* информация от активности (не от фрагмента) об индексе.
    метод будет получать от первого фрагмента индекс нажатой кнопки и передавать его второму фрагменту:*/

    @Override
    public void onButtonSelected(int buttonIndex) {
        // подключаем FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Получаем ссылку на второй фрагмент по ID
        SecondFragment fragment2 = (SecondFragment) fragmentManager.findFragmentById(R.id.fragment_second);

        // Выводим нужную информацию
        if (fragment2 != null)
            fragment2.setDescription(buttonIndex);

        /*Активность получает доступ к своим фрагментам через специальный менеджер фрагментов.
        Менеджер есть у любой активности, поэтому мы его не создаём через конструкцию new FragmentManager,
         а получаем через метод getSupportFragmentManager() или для новых версий getFragmentManager().*/
    }
}

