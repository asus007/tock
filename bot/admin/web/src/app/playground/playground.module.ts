/*
 * Copyright (C) 2017/2025 SNCF Connect & Tech
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PlaygroundComponent } from './playground.component';
import { PlaygroundRoutingModule } from './playground-routing.module';
import { BotSharedModule } from '../shared/bot-shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {
  NbAccordionModule,
  NbButtonModule,
  NbCardModule,
  NbContextMenuModule,
  NbFormFieldModule,
  NbIconModule,
  NbInputModule,
  NbRadioModule,
  NbTooltipModule
} from '@nebular/theme';

@NgModule({
  declarations: [PlaygroundComponent],
  imports: [
    CommonModule,
    BotSharedModule,
    FormsModule,
    ReactiveFormsModule,
    NbButtonModule,
    NbTooltipModule,
    NbCardModule,
    NbIconModule,
    NbAccordionModule,
    NbRadioModule,
    NbInputModule,
    NbFormFieldModule,
    NbContextMenuModule,
    PlaygroundRoutingModule
  ]
})
export class PlaygroundModule {}
