package com.ediposouza

import com.ediposouza.extensions.getArenaCardCrop
import com.ediposouza.util.BaseRecognizeTests
import com.ediposouza.util.Recognizer
import com.ediposouza.util.ReferenceConfig1024x768
import com.ediposouza.util.ReferenceConfig1366x768
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

/**
 * Created by ediposouza on 06/03/17.
 */
class ArenaCardPickRecognizeTests : BaseRecognizeTests() {

    @Before
    fun setUp() {
        TESLTracker.referenceConfig = ReferenceConfig1366x768()
    }

    @Test
    fun testArenaPick1366x768() {
        recognizeArenaPick("Pick1366x768.png", "fifthlegiontrainer", "septimguardsman", "snowwolf")
        recognizeArenaPick("ArenaPick/ArenaPick01.png", "fifthlegiontrainer", "septimguardsman", "snowwolf")
        recognizeArenaPick("ArenaPick/ArenaPick02.png", "icespike", "voraciousspriggan", "lightningbolt")
        recognizeArenaPick("ArenaPick/ArenaPick03.png", "redoranenforcer", "lightningbolt", "camlornsentinel")
        recognizeArenaPick("ArenaPick/ArenaPick04.png", "sparkingspider", "dwarvensphere", "highlandlurcher")
        recognizeArenaPick("ArenaPick/ArenaPick05.png", "varaniscourier", "crystaltowercrafter", "fightersguildrecruit")
        recognizeArenaPick("ArenaPick/ArenaPick06.png", "drestormentor", "fateweaver", "elixirofdeflection")
        recognizeArenaPick("ArenaPick/ArenaPick07.png", "chaurusreaper", "highlandlurcher", "steelsword")
        recognizeArenaPick("ArenaPick/ArenaPick08.png", "anxileelinvader", "chaurusreaper", "nimbleally")
        recognizeArenaPick("ArenaPick/ArenaPick09.png", "lightningbolt", "reachmanshaman", "arrowintheknee")
        recognizeArenaPick("ArenaPick/ArenaPick10.png", "firebolt", "darkharvester", "dunmernightblade")
        recognizeArenaPick("ArenaPick/ArenaPick11.png", "nibenbaycutthroat", "nimbleally", "shockingwamasu")
        recognizeArenaPick("ArenaPick/ArenaPick12.png", "highrocksummoner", "dunesmuggler", "dreughshellarmor")
        recognizeArenaPick("ArenaPick/ArenaPick13.png", "momentofclarity", "greentouchedspriggan", "wildbeastcaller")
        recognizeArenaPick("ArenaPick/ArenaPick14.png", "telvanniarcanist", "blacksapprotector", "shriekingharpy")
        recognizeArenaPick("ArenaPick/ArenaPick15.png", "icespike", "nibenbaycutthroat", "bardedguar")
    }

    @Test
    fun testArenaPick1360x768() {
        recognizeArenaPick("Pick1360x768.png", "fharundefender", "treeminder", "execute")
    }

    @Test
    fun testArenaPick1280x768() {
        recognizeArenaPick("Pick1280x768.png", "gardenerofswords", "elusiveschemer", "improvisedweapon")
    }

    @Test
    fun testArenaPick1024x768() {
        recognizeArenaPick("Pick1024x768.png", "gardenerofswords", "elusiveschemer", "improvisedweapon")
    }

    @Test
    fun testArenaPick1366x768WithAlternativeReferenceConfig() {
        TESLTracker.referenceConfig = ReferenceConfig1024x768()
        recognizeArenaPick("Pick1366x768.png", "fifthlegiontrainer", "septimguardsman", "snowwolf")
    }

    @Test
    fun testArenaPick1360x768WithAlternativeReferenceConfig() {
        TESLTracker.referenceConfig = ReferenceConfig1024x768()
        recognizeArenaPick("Pick1360x768.png", "fharundefender", "treeminder", "execute")
    }

    private fun recognizeArenaPick(testFileName: String, card1: String, card2: String, card3: String) {
        val croppedImage1 = getFileImage(testFileName).getArenaCardCrop(1)
        assertThat(Recognizer.recognizeCardImage(croppedImage1)).isEqualTo(card1)
        val croppedImage2 = getFileImage(testFileName).getArenaCardCrop(2)
        assertThat(Recognizer.recognizeCardImage(croppedImage2)).isEqualTo(card2)
        val croppedImage3 = getFileImage(testFileName).getArenaCardCrop(3)
        assertThat(Recognizer.recognizeCardImage(croppedImage3)).isEqualTo(card3)
    }
//    private fun recognizeArenaPick(testFileName: String, card1: String, card2: String, card3: String) {
//        val cardSimilarity = Recognizer.Similarity.DHASH_SIMILARITY_LOW
//        val croppedImage1 = getFileImage(testFileName).getArenaCardCrop(1)
//        assertThat(recognizeImage(croppedImage1, DHashCards.LIST_PHASH, similarity = cardSimilarity, outputFile = true)).isEqualTo(card1)
//        val croppedImage2 = getFileImage(testFileName).getArenaCardCrop(2)
//        assertThat(recognizeImage(croppedImage2, DHashCards.LIST_PHASH, similarity = cardSimilarity, outputFile = true)).isEqualTo(card2)
//        val croppedImage3 = getFileImage(testFileName).getArenaCardCrop(3)
//        assertThat(recognizeImage(croppedImage3, DHashCards.LIST_PHASH, similarity = cardSimilarity, outputFile = true)).isEqualTo(card3)
//    }

}