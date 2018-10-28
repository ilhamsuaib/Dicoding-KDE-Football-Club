package id.ilhamsuaib.footballclub.ui.teamDetail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import id.ilhamsuaib.footballclub.R
import id.ilhamsuaib.footballclub.model.Team
import id.ilhamsuaib.footballclub.utilities.Const
import id.ilhamsuaib.footballclub.utilities.ViewPagerAdapter
import id.ilhamsuaib.footballclub.utilities.loadImage
import kotlinx.android.synthetic.main.activity_team_detail.*

/**
 * Created by @ilhamsuaib on 28/10/18.
 * github.com/ilhamsuaib
 */

class TeamDetailActivity : AppCompatActivity() {

    private var team: Team? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)

        team = intent?.getParcelableExtra(Const.TEAM)
        setupView()
    }

    private fun setupView() {
        setSupportActionBar(toolbar)
        this.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val pagerAdapter = ViewPagerAdapter(supportFragmentManager)
        pagerAdapter.addFragment(TeamOverviewFragment.newInstance(description = team?.strDescriptionEN), getString(R.string.overview))
        pagerAdapter.addFragment(TeamPlayersFragment.newInstance(teamId = team?.idTeam), getString(R.string.players))
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)

        imgLogo.loadImage(team?.strTeamBadge)
        tvClubName.text = team?.strTeam
        tvYear.text = team?.intFormedYear
        tvStadium.text = team?.strStadium
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add_fav, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
            R.id.menu_add_to_favorite -> addToFavorite()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addToFavorite() {

    }
}