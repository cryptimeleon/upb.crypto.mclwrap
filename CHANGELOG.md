# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
### Changed
- Bumped version of mcl to `5faedff92a72a685d4e6c94e1974ec2033b9d352`

## [2.0.0]

### Fixed

- Fixed serialization of `MclBilinearGroup` returning "bn256" instead of the correct "bn254" which lead to deserialization not working


### Changed
- Made most of the mcl wrapper classes package-private

## [1.0.0] - 2021-03-19

### Added
- Initial release


[Unreleased]: https://github.com/cryptimeleon/mclwrap/compare/v1.0.0...HEAD
[1.0.0]: https://github.com/cryptimeleon/mclwrap/releases/tag/v1.0.0
