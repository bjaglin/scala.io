package io.scala.modules

import com.raquo.laminar.api.L.{*, given}
import com.raquo.laminar.api.features.unitArrows
import io.scala.data.TalksInfo.{allTalks, talksBySpeaker}
import io.scala.domaines.{Speaker, Talk}
import io.scala.modules.elements.ClassyButton
import io.scala.svgs.GoTo
import io.scala.{Page, PageArg}
import org.scalajs.dom
import org.scalajs.dom.console
import org.scalajs.dom.html.Anchor
import org.scalajs.dom.svg.{Path, SVG}

object SpeakerCard {
  def apply(speaker: Speaker) =
    div(
      className := "speaker-card",
      img(
        src       := speaker.photo.fold(io.scala.profilePlaceholder)(path => s"/images/profiles/$path"),
        className := "speaker-photo"
      ),
      div(
        div(
          talksBySpeaker(speaker).map: talk =>
            span(
              talk.kind.toString,
              className := talk.kind.toStyle
            ),
          div(
            speaker.socialNetworks,
            className := "speaker-socials"
          ),
          className := "card-subtitle"
        ),
        h2(
          speaker.name,
          className := "card-title"
        ),
        p(speaker.job),
        p(speaker.company),
        className := "speaker-information"
      ),
      linkToTalks(talksBySpeaker(speaker))
    )

  def linkToTalks(talks: Seq[Talk]) =
    talks.map{ talk =>
      button(
        className := "card-link classy-button classy-button-highlight",
        "See talk ", //! Problem if >= 2 talks
        GoTo(),
        Page.navigateTo(PageArg.Talk(talk.slug, false))
      )
    }
}
