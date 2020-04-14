package com.learn.growthcodelab

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.learn.growthcodelab.activity.*
import com.learn.growthcodelab.architecture.jetpack.courtcounter.CourtCounterActivity
import com.learn.growthcodelab.architecture.jetpack.word.ui.WordsActivity
import com.learn.growthcodelab.databinding.ActivityMainBinding
import com.learn.growthcodelab.fragment.FragmentPlayGroundActivity
import com.learn.growthcodelab.fullscreen.FullScreenActivity
import com.learn.growthcodelab.handler.HandlerActivity
import com.learn.growthcodelab.jetpack.livedata.shared.ArticleActivity
import com.learn.growthcodelab.material.MaterialActivity
import com.learn.growthcodelab.mvx.mvc.view.BookListActivity
import com.learn.growthcodelab.navigation.NavigationActivity
import com.learn.growthcodelab.rx.cheese.CheeseActivity
import com.learn.growthcodelab.search.DictionaryActivity
import com.learn.growthcodelab.search.SearchActivity
import com.learn.growthcodelab.touchagain.TouchAgainActivity
import com.learn.growthcodelab.viewshowcase.toolbar.ToolbarActivity
import com.learn.growthcodelab.viewshowcase.viewpager2.ViewPager2Activity
import com.learn.growthcodelab.window.WindowActivity
import com.learn.growthcodelab.window.WindowInsetActivity
import com.learn.growthcodelab.window.drawer.DrawerActivity

typealias Navigation = (Context) -> Unit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.getNavigation().observe(this, Observer {
                    it.getContentIfNotHandled()?.let { destination ->
                        navigationMap[destination]?.invoke(this@MainActivity)
                    }
                })
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            viewModel =  mainActivityViewModel
        }
    }

    private companion object {
        val navigationMap: Map<Int, Navigation> = mapOf(
                R.id.btn_main_data_binding to { context -> DataBindingActivity.start(context) },
                R.id.btn_main_fit_system_window to { context -> WindowInsetActivity.start(context) },
                R.id.btn_main_web_view to { context -> WebViewActivity.start(context) },
                R.id.btn_main_measurement to { context -> MeasurementActivity.start(context) },
                R.id.btn_main_drawable to { context -> DrawableActivity.start(context) },
                R.id.btn_main_play_ground to { context -> BookListActivity.start(context) },
                R.id.btn_main_layout to { context -> LayoutActivity.start(context) },
                R.id.btn_main_view_pager to { context -> ViewPagerActivity.start(context) },
                R.id.btn_main_tab_host to { _ -> Unit },
                R.id.btn_main_scene to { context -> TransitionActivity.start(context) },
                R.id.btn_main_full_screen to { context -> FullScreenActivity.start(context) },
                R.id.btn_main_handler to { context -> HandlerActivity.start(context) },
                R.id.btn_main_touch_again to { context -> TouchAgainActivity.start(context) },
                R.id.btn_main_search to { context -> DictionaryActivity.start(context) },
                R.id.btn_main_window to { context -> WindowActivity.start(context) },
                R.id.btn_view_showcase to { context -> ToolbarActivity.start(context) },
                R.id.btn_main_words to { context -> WordsActivity.start(context) },
                R.id.btn_fragment_play_ground to { context -> FragmentPlayGroundActivity.start(context) },
                R.id.btn_drawer to { context -> DrawerActivity.start(context) },
                R.id.btn_main_court_counter to { context -> CourtCounterActivity.start(context) },
                R.id.btn_jet_pack to { context -> ArticleActivity.start(context) },
                R.id.btn_navigation to { context -> NavigationActivity.start(context) },
                R.id.btn_material to { context -> ViewPager2Activity.start(context)}
        )
    }
}