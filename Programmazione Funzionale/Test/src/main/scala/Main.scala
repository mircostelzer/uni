def flatten(list: List[Any]): List[Any] =
  list match{
    case (x: List[Any])::xs =>
      flatten(x)::flatten(xs)
    case x::xs => x::flatten(xs)
    case Nil => Nil
  };

