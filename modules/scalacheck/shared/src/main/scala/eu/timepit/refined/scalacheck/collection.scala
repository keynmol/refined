package eu.timepit.refined.scalacheck

import eu.timepit.refined.api.{Refined, RefType}
import eu.timepit.refined.collection.Size
import org.scalacheck.{Arbitrary, Gen}
import org.scalacheck.util.Buildable

/** Module that provides `Arbitrary` instances for collection predicates. */
object collection extends CollectionInstances

trait CollectionInstances {

  implicit def listSizeArbitrary[F[_, _]: RefType, T, P](
      implicit
      arbT: Arbitrary[T],
      arbSize: Arbitrary[Int Refined P]
  ): Arbitrary[F[List[T], Size[P]]] =
    buildableSizeArbitrary[F, List[T], T, P]

  implicit def vectorSizeArbitrary[F[_, _]: RefType, T, P](
      implicit
      arbT: Arbitrary[T],
      arbSize: Arbitrary[Int Refined P]
  ): Arbitrary[F[Vector[T], Size[P]]] =
    buildableSizeArbitrary[F, Vector[T], T, P]

  // This is private and not implicit because it could produce invalid
  // values for some collections:
  //
  // scala> buildableSizeArbitrary[Refined, Set[Boolean], Boolean, Equal[3]].arbitrary.sample
  // res0: Option[Refined[Set[Boolean], Size[Equal[3]]]] = Some(Set(false, true))
  private[scalacheck] def buildableSizeArbitrary[F[_, _]: RefType, C, T, P](
      implicit
      arbT: Arbitrary[T],
      arbN: Arbitrary[Int Refined P],
      ev1: Buildable[T, C],
      ev2: C => Traversable[T]
  ): Arbitrary[F[C, Size[P]]] =
    arbitraryRefType(arbN.arbitrary.flatMap { n =>
      Gen.buildableOfN[C, T](n.value, arbT.arbitrary)
    })
}
