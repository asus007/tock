#   Copyright (C) 2024 Credit Mutuel Arkea
#
#   Licensed under the Apache License, Version 2.0 (the "License");
#   you may not use this file except in compliance with the License.
#   You may obtain a copy of the License at
#
#   http://www.apache.org/licenses/LICENSE-2.0
#
#   Unless required by applicable law or agreed to in writing, software
#   distributed under the License is distributed on an "AS IS" BASIS,
#   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#   See the License for the specific language governing permissions and
#   limitations under the License.
#
from gen_ai_orchestrator.configurations.environement.settings import _Settings
from gen_ai_orchestrator.configurations.logging.logger import setup_logging


def test_environment():
    """Test settings are read successfully"""
    _Settings()


def test_logging():
    """Test logger is instantiated successfully."""
    setup_logging()