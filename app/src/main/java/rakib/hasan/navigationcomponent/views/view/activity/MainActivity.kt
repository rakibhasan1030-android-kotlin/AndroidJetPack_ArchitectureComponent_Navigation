package rakib.hasan.navigationcomponent.views.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import rakib.hasan.navigationcomponent.MainNavGraphDirections
import rakib.hasan.navigationcomponent.R
import rakib.hasan.navigationcomponent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.activityMainToolbar)

        //with appbar configuration first param, we declare the all top level destinations, so that, back button never showed in that destination
        //with appbar configuration second param, we pass drawer layout so that then hamburger icon of navigation drawer is shown
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment, R.id.settingsFragment, R.id.notificationsFragment),
            binding.activityMainDrawerLayout
        )

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.activityMainNavHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController, appBarConfiguration)


        binding.activityMainBottomNavView.setupWithNavController(navController)
        binding.activityMainNavDrawer.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        //pass appBarConfiguration in navigateUp so that the hamburger icon of navigation drawer will work properly
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.main_menu_about_app ->{
                val action = MainNavGraphDirections.actionGlobalAboutAppFragment()
                navController.navigate(action)
                return true
            } else -> item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

}