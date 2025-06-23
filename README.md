# DHSnowFix
A simple Fabric Minecraft mod that fixes snow layers rendering as full blocks in Distant Horizons.\
image placeholder\
(The bottom picture is with this mod installed, "Tint with avoided blocks" in DH's config is enabled)\
\
This mod seems to be needed at least as a hopefully temporary solution since over on Distant Horizons' issue tracker [the issue about this problem](https://gitlab.com/distant-horizons-team/distant-horizons/-/issues/947) was closed without resolution and seems to be a "won't fix" because it's "expected behavior".\
So then Minecraft itself should change?\
\
This mod achieves what it does by making the snow layer block non-opaque and transparent, because that's what Distant Horizons checks for when it chooses blocks to avoid/tint blocks below with.
* Gameplay-wise this means that snow layers now let light through. Even though it's unrealistic, you can now have skylight come underground through snow on top of glass without people noticing it!
* Performance-wise this means that there's now an additional check whether the current block is a snow layer block every time the game checks whether the block is opaque when it needs to decide whether to render a block side or not, which is obviously far from ideal. 

### Installation
Requires Minecraft 1.20.1 and [Fabric Loader](https://fabricmc.net/) >=0.14.25.

### License
DHSnowFix is licensed under MIT.
