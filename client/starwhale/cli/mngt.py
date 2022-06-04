import click

from starwhale.mngt import gc, open_web


def add_mngt_command(cli: click.core.Group) -> None:
    @cli.command("gc", help="Garbage collection")
    @click.option("--dry-run", is_flag=True, help="dry-run cleanup garbage collection")
    @click.option("--yes", is_flag=True, help="all confirm yes")
    def _gc(dry_run: bool, yes: bool) -> None:
        gc(dry_run, yes)

    @cli.command("ui", help="Open web ui")
    @click.argument("instance", default="")
    def _ui(instance: str) -> None:
        open_web(instance)
