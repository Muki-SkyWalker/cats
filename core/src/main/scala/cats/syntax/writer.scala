package cats
package syntax

import cats.data.Writer

trait WriterSyntax {
  implicit def writerIdSyntax[A](a: A): WriterIdSyntax[A] = new WriterIdSyntax(a)
}

final class WriterIdSyntax[A](val a: A) extends AnyVal {
  def tell: Writer[A, Unit] = Writer(a, ())
  def writer[W](w: W): Writer[W, A] = Writer(w, a)
}
