package id.ilhamsuaib.footballclub.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import id.ilhamsuaib.footballclub.model.Match
import kotlinx.android.parcel.Parcelize
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by @ilhamsuaib on 05/10/18.
 * github.com/ilhamsuaib
 */

@Parcelize
data class MatchModel(
        @field:SerializedName("idEvent")
        val idEvent: String? = null,
        @field:SerializedName("idSoccerXML")
        val idSoccerXML: String? = null,
        @field:SerializedName("strEvent")
        val strEvent: String? = null,
        @field:SerializedName("strFilename")
        val strFilename: String? = null,
        @field:SerializedName("strSport")
        val strSport: String? = null,
        @field:SerializedName("idLeague")
        val idLeague: String? = null,
        @field:SerializedName("strLeague")
        val strLeague: String? = null,
        @field:SerializedName("strSeason")
        val strSeason: String? = null,
        @field:SerializedName("strDescriptionEN")
        val strDescriptionEN: String? = null,
        @field:SerializedName("strHomeTeam")
        val strHomeTeam: String? = null,
        @field:SerializedName("strAwayTeam")
        val strAwayTeam: String? = null,
        @field:SerializedName("intHomeScore")
        val intHomeScore: String? = null,
        @field:SerializedName("intRound")
        val intRound: String? = null,
        @field:SerializedName("intAwayScore")
        val intAwayScore: String? = null,
        @field:SerializedName("intSpectators")
        val intSpectators: String? = null,
        @field:SerializedName("strHomeGoalDetails")
        val strHomeGoalDetails: String? = null,
        @field:SerializedName("strHomeRedCards")
        val strHomeRedCards: String? = null,
        @field:SerializedName("strHomeYellowCards")
        val strHomeYellowCards: String? = null,
        @field:SerializedName("strHomeLineupGoalkeeper")
        val strHomeLineupGoalkeeper: String? = null,
        @field:SerializedName("strHomeLineupDefense")
        val strHomeLineupDefense: String? = null,
        @field:SerializedName("strHomeLineupMidfield")
        val strHomeLineupMidfield: String? = null,
        @field:SerializedName("strHomeLineupForward")
        val strHomeLineupForward: String? = null,
        @field:SerializedName("strHomeLineupSubstitutes")
        val strHomeLineupSubstitutes: String? = null,
        @field:SerializedName("strHomeFormation")
        val strHomeFormation: String? = null,
        @field:SerializedName("strAwayRedCards")
        val strAwayRedCards: String? = null,
        @field:SerializedName("strAwayYellowCards")
        val strAwayYellowCards: String? = null,
        @field:SerializedName("strAwayGoalDetails")
        val strAwayGoalDetails: String? = null,
        @field:SerializedName("strAwayLineupGoalkeeper")
        val strAwayLineupGoalkeeper: String? = null,
        @field:SerializedName("strAwayLineupDefense")
        val strAwayLineupDefense: String? = null,
        @field:SerializedName("strAwayLineupMidfield")
        val strAwayLineupMidfield: String? = null,
        @field:SerializedName("strAwayLineupForward")
        val strAwayLineupForward: String? = null,
        @field:SerializedName("strAwayLineupSubstitutes")
        val strAwayLineupSubstitutes: String? = null,
        @field:SerializedName("strAwayFormation")
        val strAwayFormation: String? = null,
        @SerializedName("intHomeShots")
        val intHomeShots: String? = null,
        @SerializedName("intAwayShots")
        val intAwayShots: String? = null,
        @field:SerializedName("dateEvent")
        val dateEvent: String? = null,
        @field:SerializedName("strDate")
        val strDate: String? = null,
        @field:SerializedName("strTime")
        val strTime: String? = null,
        @field:SerializedName("strTVStation")
        val strTVStation: String? = null,
        @field:SerializedName("idHomeTeam")
        val idHomeTeam: String? = null,
        @field:SerializedName("idAwayTeam")
        val idAwayTeam: String? = null,
        @field:SerializedName("strResult")
        val strResult: String? = null,
        @field:SerializedName("strCircuit")
        val strCircuit: String? = null,
        @field:SerializedName("strCountry")
        val strCountry: String? = null,
        @field:SerializedName("strCity")
        val strCity: String? = null,
        @field:SerializedName("strPoster")
        val strPoster: String? = null,
        @field:SerializedName("strFanart")
        val strFanart: String? = null,
        @field:SerializedName("strThumb")
        val strThumb: String? = null,
        @field:SerializedName("strBanner")
        val strBanner: String? = null,
        @field:SerializedName("strMap")
        val strMap: String? = null,
        @field:SerializedName("strLocked")
        val strLocked: String? = null
) : Parcelable {
    fun transform(): Match {
        return Match(
                id = null,
                matchId = this.idEvent,
                homeTeamId = this.idHomeTeam,
                awayTeamId = this.idAwayTeam,
                homeTeamName = this.strHomeTeam,
                awayTeamName = this.strAwayTeam,
                homeScore = this.intHomeScore,
                awayScore = this.intAwayScore,
                strTime = toWib(this.strTime),
                matchDate = this.dateEvent
        )
    }

    private fun toWib(strTime: String?): String? {
        return try {
            val sdf = SimpleDateFormat("HH:mm:ssX", Locale.getDefault())
            val newTime = sdf.parse(strTime)
            val newSdf = SimpleDateFormat("HH:mm", Locale.getDefault())
            newSdf.format(newTime)
        } catch (e: ParseException) {
            try {
                val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
                val newTime = sdf.parse(strTime)
                val newSdf = SimpleDateFormat("HH:mm", Locale.getDefault())
                newSdf.format(newTime)
            } catch (e: ParseException) {
                strTime
            }
        }
    }
}