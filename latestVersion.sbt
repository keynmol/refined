ThisBuild / latestVersion := "0.9.24"

ThisBuild / bincompatVersions := Map(
  "2.12" -> Set(
    "0.9.3",
    "0.9.4",
    "0.9.5",
    "0.9.6",
    "0.9.7",
    "0.9.8",
    "0.9.9",
    "0.9.10",
    "0.9.12",
    "0.9.13",
    "0.9.14",
    "0.9.15",
    "0.9.16",
    "0.9.17",
    "0.9.18",
    "0.9.19",
    "0.9.20",
    "0.9.21",
    "0.9.22",
    "0.9.23",
    "0.9.24",
    "0.9.25",
    "0.9.26"
    // NEXT_VERSION
  ),
  "2.13" -> Set(
    "0.9.10",
    "0.9.12",
    "0.9.13",
    "0.9.14",
    "0.9.15",
    "0.9.16",
    "0.9.17",
    "0.9.18",
    "0.9.19",
    "0.9.20",
    "0.9.21",
    "0.9.22",
    "0.9.23",
    "0.9.24",
    "0.9.25",
    "0.9.26"
    // NEXT_VERSION
  )
)

ThisBuild / unreleasedModules := Set(
  // Example:
  // "refined-eval"
)
