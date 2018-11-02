package domain

sealed trait FrameBonus
case object Non extends FrameBonus
case object Strike extends FrameBonus
case object Spare extends FrameBonus
